package com.hackyeah2024.feed.feed;

import org.springframework.stereotype.Service;
import com.hackyeah2024.feed.recommender.RecommenderOuterClass;

@Service
public class RequesterMapper {
    public RecommenderOuterClass.RequesterType toRequesterType(String requester) {
        return switch (requester) {
            case "REQUESTER_VOLUNTEER" -> RecommenderOuterClass.RequesterType.REQUESTER_VOLUNTEER;
            case "REQUESTER_COMPANY" -> RecommenderOuterClass.RequesterType.REQUESTER_COMPANY;
            case "REQUESTER_NGO" -> RecommenderOuterClass.RequesterType.REQUESTER_NGO;
            case null, default -> RecommenderOuterClass.RequesterType.REQUESTER_UNKNOWN;
        };
    }

    public String toString(RecommenderOuterClass.RequesterType requesterType) {
        return switch (requesterType){
            case REQUESTER_VOLUNTEER -> "REQUESTER_VOLUNTEER";
            case REQUESTER_COMPANY -> "REQUESTER_COMPANY";
            case REQUESTER_NGO -> "REQUESTER_NGO";
            case null, default -> "REQUESTER_UNRECOGNIZED";
        };
    }

    public RecommenderOuterClass.RequestedType toRequestedType(String requested) {
        return switch (requested) {
            case "REQUESTED_VOLUNTEER" -> RecommenderOuterClass.RequestedType.REQUESTED_VOLUNTEER;
            case "REQUESTED_COMPANY" -> RecommenderOuterClass.RequestedType.REQUESTED_COMPANY;
            case "REQUESTED_NGO" -> RecommenderOuterClass.RequestedType.REQUESTED_NGO;
            case null, default -> RecommenderOuterClass.RequestedType.REQUESTED_UNKNOWN;
        };
    }

    public String toString(RecommenderOuterClass.RequestedType requestedType) {
        return switch (requestedType){
            case RecommenderOuterClass.RequestedType.REQUESTED_VOLUNTEER -> "REQUESTED_VOLUNTEER";
            case RecommenderOuterClass.RequestedType.REQUESTED_COMPANY -> "REQUESTED_COMPANY";
            case RecommenderOuterClass.RequestedType.REQUESTED_NGO -> "REQUESTED_NGO";
            case null, default -> "REQUESTED_UNRECOGNIZED";
        };
    }
}
