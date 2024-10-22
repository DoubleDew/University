if __name__ == "__main__":
    def compute(a,b,c,d):
        if int(a) > 10 & int(b) > 10 & int(c) > 10 & int(d) > 10:
            print("variable is too big")
        elif int(a) <=10 & int(b) > 10 & int(c) > 10 & int(d) > 10:
            m = int(a) + int(b) * int(c) + int(c)
            print("Mult: ", m)
        return "Result = " + str(m)
    a = input("a = ")
    b = input("b = ")
    c = input("c = ")
    d = input("d = ")
    print(compute(a,b,c,d))