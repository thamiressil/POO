class Calc:
    def __init__(self):
        self.bateria = 0
        self.bateriaMax = 10

def _str_(self):
    return "Carga: " + str(self.bateria)

def recarregar(self, valor):
    self.bateria +=  valor
    if self.bateria > self.bateriaMax:
        self.bateria = self.bateriaMax


def soma(self, a, b):
    if self.bateria != 0:
        self.bateria -= 1
        return str(a+b)
    else:
        return "Bateria insuficiente"

def divisao (self, a, b):
    if self.bateria != 0:
        self.bateria -= 1
        if(b == 0):
            return "divisao por 0"
        else:
            return str(a / b)
    else:
        return "Bateria insuficiente"


calc = Calc()

print("encerrar, mostrar, iniciar_valor, recarregar_valor, soma _a _b, divisao_a_b ")
while True:
    ui = input().split(" ")
    if ui[0] == "encerrar":
        break
    elif ui[0] == "init":
        calc = Calc()
    elif ui[0] == "mostrar":
        print(_str_(calc))
    elif ui[0] == "recarregar":
        recarregar(calc, int(ui[1]))
    elif ui[0] == "soma":
        print(soma(calc, int(ui[1]), int(ui[2])))
    elif ui[0] == "divisao":
        print(divisao(calc, int(ui[1]), int(ui[2])))
    else:
        print("comando invalido")
