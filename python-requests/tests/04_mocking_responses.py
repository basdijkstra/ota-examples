import requests
import responses
import pytest
import json

from requests.exceptions import ConnectionError
from urllib.parse import urlparse


@responses.activate
def test_simulate_data_cannot_be_found():
    responses.add(
        responses.GET,
        'http://api.zippopotam.us/us/90210',
        json={"error": "No data exists for US zip code 90210"},
        status=404
    )

    response = requests.get('http://api.zippopotam.us/us/90210')
    assert response.status_code == 404
    response_body = response.json()
    assert response_body['error'] == 'No data exists for US zip code 90210'


@responses.activate
def test_unmatched_endpoint_raises_connectionerror():
    with pytest.raises(ConnectionError):
        requests.get('http://api.zippopotam.us/us/12345')


@responses.activate
def test_responses_can_raise_error_on_demand():
    responses.add(
        responses.GET,
        'http://api.zippopotam.us/us/99999',
        body=RuntimeError('A runtime error occurred')
    )

    with pytest.raises(RuntimeError) as re:
        requests.get('http://api.zippopotam.us/us/99999')
    assert str(re.value) == 'A runtime error occurred'


@responses.activate
def test_using_a_callback_for_dynamic_responses():

    def request_callback(request):
        request_url = request.url
        resp_body = {'value': generate_response_from(request_url)}
        return 200, {}, json.dumps(resp_body)

    responses.add_callback(
        responses.GET, 'http://api.zippopotam.us/us/55555',
        callback=request_callback,
        content_type='application/json',
    )

    response = requests.get('http://api.zippopotam.us/us/55555')
    assert response.json() == {'value': 'You requested data for US zip code 55555'}

    assert len(responses.calls) == 1
    assert responses.calls[0].request.url == 'http://api.zippopotam.us/us/55555'
    assert responses.calls[0].response.text == '{"value": "You requested data for US zip code 55555"}'


def generate_response_from(url):
    parsed_url = urlparse(url).path
    split_url = parsed_url.split('/')
    return f'You requested data for {split_url[1].upper()} zip code {split_url[2]}'
