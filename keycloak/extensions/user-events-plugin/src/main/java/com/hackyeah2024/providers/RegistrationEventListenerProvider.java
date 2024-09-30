package com.hackyeah2024.providers;


import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistrationEventListenerProvider implements EventListenerProvider, EventListenerProviderFactory {

    private static final Logger logger = Logger.getLogger(RegistrationEventListenerProvider.class.getName());
    private String apiUrl;

    @Override
    public void onEvent(Event event) {
        if (EventType.REGISTER.equals(event.getType())) {
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");

                String jsonInputString = String.format(
                        "{\"username\": \"%s\", \"email\": \"%s\", \"firstName\": \"%s\", \"lastName\": \"%s\"}",
                        event.getDetails().get("username"), event.getDetails().get("email"),
                        event.getDetails().get("first_name"), event.getDetails().get("last_name")
                );

                conn.setDoOutput(true);
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int responseCode = conn.getResponseCode();
                logger.log(Level.INFO, "POST Response Code :: {0}", responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    logger.log(Level.INFO, "User registration data sent successfully.");
                } else {
                    logger.log(Level.SEVERE, "Failed to send user registration data.");
                }

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error sending user registration data", e);
            }
        }
    }

    @Override
    public void close() {
        // No-op
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean includeRepresentation) {
        // Implementacja tej metody jest wymagana, ale możesz zostawić ją pustą, jeśli jej nie potrzebujesz
    }

    @Override
    public EventListenerProvider create(KeycloakSession session) {
        return this;
    }

    @Override
    public void init(org.keycloak.Config.Scope scope) {
        this.apiUrl = System.getenv("REGISTRATION_API_URL");
        if (apiUrl == null || apiUrl.isEmpty()) {
            throw new RuntimeException("REGISTRATION_API_URL environment variable is not set.");
        }
        logger.log(Level.INFO, "Registration API URL set to: {0}", apiUrl);
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // No-op
    }

    @Override
    public String getId() {
        return "registration-event-listener";
    }

}
