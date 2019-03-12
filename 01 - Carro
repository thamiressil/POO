class carro:
    def __init__(self):
        self.pas = 0
        self.gas = 0
        self.km = 0
        self.pas_qtd = 2
        self.gas_qtd = 10

def __str__(self):
    return "pass: " + str(self.pas) + ", gas: " + str(self.gas) + ", km: " + str(self.km)

def entrar(self):
    if self.pas == self.pas_qtd:
        print("fail: limite de pessoas atingido")
    else:
        self.pas +=1

def sair(self):
    if self.pas >0:
        self.pas -=1
    else:
        print("nao ha ninguem carro")

def abastecer (self):
    gas_qtd = int(input("digite a quantidade de gasolina "))
    self.gas += gas_qtd
    if self.gas > self.gas_qtd:
        self.gas = self.gas_qtd

def andar (self):
    dist = int(input("digite a distancia "))
    if self.pas !=0 and self.gas >= (dist/10):
        self.gas -= dist/10
        self.km += dist
    elif self.pas == 0:
        print("nao ha ninguem no carro")
    else:
        print ("nao ha gasolina")
car = carro()
line = " "
print("digite: encerrar, entra, sair, abastecer, andar ou fim")

while line != "fim" :
    line = input()
    user = line.split(" ")
    if user == "encerrar":
        break
    elif user[0] == "mostrar":
        print(__str__(car))
    elif user[0] == "entrar" :
        entrar(car)
    elif user[0] == "sair":
        sair(car)
    elif user[0] == "abastecer":
        abastecer(car)
    elif user[0] == "andar":
        andar(car)
    else:
        print ("comando invalido")
