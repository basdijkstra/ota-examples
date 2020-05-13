from singleton import MySingleton

import pytest

# def test_singleton_can_be_instantiated():
#     my_singleton = MySingleton()
#     assert my_singleton is not None


# def test_singleton_can_take_an_argument():
#     my_singleton = MySingleton(fruit='banana')
#     assert my_singleton.fruit == 'banana'


# def test_singleton_instance_is_stored_as_a_class_variable():
#     my_singleton = MySingleton(fruit='pear')
#     assert my_singleton.instance is not None


# def test_singleton_class_variable_exposes_properties():
#     my_singleton = MySingleton(fruit='apple')
#     assert my_singleton.instance.fruit == 'apple'


def test_singleton_cannot_be_instantiated_twice():
    MySingleton(fruit='grape')
    with pytest.raises(RuntimeError) as re:
        MySingleton(fruit='pineapple')
    assert str(re.value) == 'Already instantiated!'


def test_singleton_retains_initial_property_values_after_subsequent_init_calls():
    MySingleton(fruit='lychee')
    with pytest.raises(RuntimeError):
        MySingleton(fruit='orange')
    assert MySingleton.instance().fruit == 'lychee'


def test_singleton_instance_is_accessible_using_class_method():
    MySingleton(fruit='raspberry')
    my_singleton_instance = MySingleton.instance()
    assert my_singleton_instance.fruit == 'raspberry'


def test_singleton_instance_field_is_not_directly_accessible():
    with pytest.raises(AttributeError) as ae:
        MySingleton(fruit='peach').__instance
    assert str(ae.value) == "'MySingleton' object has no attribute '__instance'"
