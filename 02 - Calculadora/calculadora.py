class Calc:
    def __init__(self):
        self.bateria = 0
        self.bateriaMax = 10

def _str_(self):
    return "Carga: " + str(self.bateria)

def recarregar(self):
    valor = int(input("digite a carga "))
    self.bateria +=  valor
    if self.bateria > self.bateriaMax:
        self.bateria = self.bateriaMax


def soma(self):
    if self.bateria != 0:
        a = int(input("digite o numero "))
        b = int(input("digite o numero "))
        self.bateria -= 1
        return str(a+b)
    else:
        return "Bateria insuficiente"

def div(self):
    if self.bateria != 0:
        a = int(input("digite o numero "))
        b = int(input("digite o numero "))
        self.bateria -= 1
        if(b == 0):
            return "divisao por 0"
        else:
            return str(a / b)
    else:
        return "Bateria insuficiente"


calcu = Calc()
print("mostrar, iniciar_maxCarga, recarregar_valCarga")
line = ""
while line != "fim" :
    line = input()

    if line == "recarregar":
        recarregar(calcu)
    elif line == "soma":
        print(soma(calcu))
    elif line == "divisao":
        print(div(calcu))
    elif line == "mostrar":
        print(_str_(calcu))
    else:
        print("opcao invalida!")
