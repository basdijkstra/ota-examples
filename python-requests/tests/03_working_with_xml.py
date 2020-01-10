import requests
import xml.etree.ElementTree as et


def fixed_xml_body_as_string():
    return """
    <payee>
        <name>John Smith</name>
        <address>
            <street>My street</street>
            <city>My city</city>
            <state>My state</state>
            <zipCode>90210</zipCode>
        </address>
        <phoneNumber>0123456789</phoneNumber>
        <accountNumber>12345</accountNumber>
    </payee>
    """


def test_send_xml_body_from_string_check_status_code_and_content_type():
    response = requests.post(
        "http://parabank.parasoft.com/parabank/services/bank/billpay?accountId=12345&amount=500",
        headers={"Content-Type": "application/xml"},
        data=fixed_xml_body_as_string()
    )
    assert response.status_code == 200
    assert response.headers["Content-Type"] == "application/xml"


def create_xml_body_using_elementtree():
    payee = et.Element('payee')
    name = et.SubElement(payee, 'name')
    name.text = 'John Smith'
    address = et.SubElement(payee, 'address')
    street = et.SubElement(address, 'street')
    street.text = 'My street'
    city = et.SubElement(address, 'city')
    city.text = 'My city'
    state = et.SubElement(address, 'state')
    state.text = 'My state'
    zip_code = et.SubElement(address, 'zipCode')
    zip_code.text = '90210'
    phone_number = et.SubElement(payee, 'phoneNumber')
    phone_number.text = '0123456789'
    account_number = et.SubElement(payee, 'accountNumber')
    account_number.text = '12345'
    return et.tostring(payee)


def test_send_xml_body_from_elementtree_check_status_code_and_content_type():
    response = requests.post(
        "http://parabank.parasoft.com/parabank/services/bank/billpay?accountId=12345&amount=500",
        headers={"Content-Type": "application/xml"},
        data=create_xml_body_using_elementtree()
    )
    assert response.status_code == 200
    assert response.headers["Content-Type"] == "application/xml"


def test_check_root_of_xml_response():
    response = requests.get("http://parabank.parasoft.com/parabank/services/bank/accounts/12345")
    response_body_as_xml = et.fromstring(response.content)
    xml_tree = et.ElementTree(response_body_as_xml)
    root = xml_tree.getroot()
    assert root.tag == "account"
    assert len(root.attrib) == 0
    assert root.text is None


def test_check_specific_element_of_xml_response():
    response = requests.get("http://parabank.parasoft.com/parabank/services/bank/accounts/12345")
    response_body_as_xml = et.fromstring(response.content)
    xml_tree = et.ElementTree(response_body_as_xml)
    first_name = xml_tree.find("customerId")
    assert first_name.text == "12212"


def test_check_number_of_accounts_for_12212_greater_than_five():
    response = requests.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/accounts")
    response_body_as_xml = et.fromstring(response.content)
    xml_tree = et.ElementTree(response_body_as_xml)
    accounts = xml_tree.findall(".//account")
    assert len(accounts) > 5


def test_use_xpath_for_more_sophisticated_checks():
    response = requests.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/accounts")
    response_body_as_xml = et.fromstring(response.content)
    xml_tree = et.ElementTree(response_body_as_xml)
    savings_accounts = xml_tree.findall(".//account/type[.='SAVINGS']")
    assert len(savings_accounts) > 1
