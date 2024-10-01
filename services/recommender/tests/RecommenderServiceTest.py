import unittest

import grpc
import proto
from ..proto import recommender_pb2_grpc
from ..proto import recommender_pb2

class RecommenderServiceTest(unittest.TestCase):
    def test_get_recommendations(self):
        # Tworzenie obiektu klienta GRPC
        channel = grpc.insecure_channel('localhost:50051')
        stub = proto.recomender_pb2_grpc.RecommenderStub(channel)

        # Tworzenie żądania
        request = proto.recomender_pb2.RecommendationRequest(
            user_id='test_user',
            requester_type=proto.recomender_pb2.REQUESTER_COMPANY,
            requested_type=proto.recomender_pb2.REQUESTED_COMPANY
        )

        # Wysyłanie żądania i odbieranie odpowiedzi
        response = stub.GetRecommendations(request)

        # Sprawdzanie, czy odpowiedź jest poprawna
        self.assertEqual(len(response.recommended_items), 0)

if __name__ == "__main__":
    unittest.main()