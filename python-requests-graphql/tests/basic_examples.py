import requests


query_company_ceo_coo_name = """
{
  company {
    ceo
    coo
    name
  }
}
"""


def test_retrieve_graphql_data_should_yield_http_200():
    response = requests.post("https://api.spacex.land/graphql/", json={'query': query_company_ceo_coo_name})
    assert response.status_code == 200


def test_retrieve_graphql_data_should_yield_server_cowboy():
    response = requests.post("https://api.spacex.land/graphql/", json={'query': query_company_ceo_coo_name})
    assert response.headers['Server'] == 'Cowboy'


def test_retrieve_graphql_data_should_yield_encoding_utf8():
    response = requests.post("https://api.spacex.land/graphql/", json={'query': query_company_ceo_coo_name})
    assert response.encoding == 'utf-8'


def test_retrieve_graphql_data_should_yield_ceo_elon_musk():
    response = requests.post("https://api.spacex.land/graphql/", json={'query': query_company_ceo_coo_name})
    response_body = response.json()
    assert response_body['data']['company']['ceo'] == 'Elon Musk'


query_missions = """
{
  missions {
    id
  }
}
"""


def test_retrieve_mission_ids_count_should_be_10():
    response = requests.post("https://api.spacex.land/graphql/", json={'query': query_missions})

    response_body = response.json()
    assert len(response_body['data']['missions']) == 10
