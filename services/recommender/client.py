import grpc
from concurrent import futures
import sys
import os

from proto import recommender_pb2_grpc
from proto import recommender_pb2


# Add the root directory (parent of proto folder) to sys.path
sys.path.append(os.path.dirname(os.path.abspath(__file__)))


def run(p1 :str, p2 :str, p3 :str):
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = recommender_pb2_grpc.RecommenderStub(channel)
        response = stub.GetRecommendations(recommender_pb2.RecommendationRequest(user_id=p1, requester_type=p2, requested_type=p3))
    print(f"Result: {response.recommended_items}")

if __name__ == '__main__':
    # Get user Input
    par1 = input("Please input 1: ")
    par2 = input("Please input 2: ")
    par3 = input("Please input 3: ")
    run(par1, par2, par3)