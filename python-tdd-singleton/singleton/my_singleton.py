# class MySingleton:
#
#     def __init__(self):
#         pass

# -------------------------------------

# class MySingleton:
#
#     def __init__(self, fruit: str):
#         self.fruit = fruit

# -------------------------------------

# class MySingleton:
#
#     instance = None
#
#     def __init__(self, fruit: str):
#         MySingleton.instance = self

# -------------------------------------

# class MySingleton:
#
#     instance = None
#
#     def __init__(self, fruit: str):
#         MySingleton.instance = self
#         MySingleton.instance.fruit = fruit

# -------------------------------------

# class MySingleton:
#
#     instance = None
#
#     def __init__(self, fruit: str):
#         if self.instance is not None:
#             raise RuntimeError('Already instantiated!')
#         MySingleton.instance = self
#         MySingleton.instance.fruit = fruit

# ---------------------------------------

class MySingleton:

    __instance = None

    def __init__(self, fruit: str):
        if MySingleton.__instance is not None:
            raise RuntimeError('Already instantiated!')
        MySingleton.__instance = self
        MySingleton.__instance.fruit = fruit

    @classmethod
    def instance(cls):
        return cls.__instance
