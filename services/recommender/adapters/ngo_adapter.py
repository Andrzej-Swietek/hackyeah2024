from adapters.http_client_adapter import HTTPClientAdapter


class NGOAdapter:
    def __init__(self, base_url: str):
        self.base_url = base_url
        self.http_client = HTTPClientAdapter()

    def get_ngo_recommendations(self, user_id: str):
        url = f"{self.base_url}/ngos/recommendations"
        params = {"user_id": user_id}
        return self.http_client.get(url, params)
