package com.hackyeah2024.feed.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import com.hackyeah2024.feed.recommender.RecommenderOuterClass;
import com.hackyeah2024.feed.recommender.RecommenderGrpc;
import java.util.List;
import java.util.stream.Collectors;


public class RecommenderClient {

    private final ManagedChannel channel;
    private final RecommenderGrpc.RecommenderBlockingStub stub;
    private final String userId;
    private final RecommenderOuterClass.RequestedType requestedType;
    private final RecommenderOuterClass.RequesterType requesterType;

    public RecommenderClient(String userId, RecommenderOuterClass.RequesterType requesterType, RecommenderOuterClass.RequestedType requestedType) {
        this.userId = userId;
        this.requesterType = requesterType;
        this.requestedType = requestedType;


        // Initialize the channel and stub
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        stub = RecommenderGrpc.newBlockingStub(channel);
    }

    public List<String> getRecommendations() {
        // Create the request
        RecommenderOuterClass.RecommendationRequest request = RecommenderOuterClass.RecommendationRequest.newBuilder()
                .setUserId(this.userId)
                .setRequesterType(this.requesterType)
                .setRequestedType(this.requestedType)
                .build();

        try {
            // Call the gRPC method
            RecommenderOuterClass.RecommendationResponse response = stub.getRecommendations(request);
            System.out.println("Recommendations: " + response.getRecommendedItemsList());
            return response.getRecommendedItemsList()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
        return List.of();
    }

    public void shutdown() {
        channel.shutdown();
    }

}
