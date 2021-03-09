import requests

from sgqlc.types import String, Type, Field
from sgqlc.operation import Operation


class MissionNode(Type):
    id = String
    name = String
    description = String


class Query(Type):
    missions = Field(MissionNode)


def test_create_graphql_query_programmatically():

    query = Operation(Query)
    query.missions()

    response = requests.post("https://api.spacex.land/graphql/", json={'query': str(query)})
    assert response.status_code == 200
    assert len(response.json()['data']['missions']) == 10
