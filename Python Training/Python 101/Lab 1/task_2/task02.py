def func(nume_complete):
    """
    Creeaza un tuplu "nume_formatat" care sa contina 3 elemente:
    nume_formatat[0] = lista cu numele de familie
    nume_formatat[1] = lista cu primele prenume
    nume_formatat[2] = lista cu celelalte prenume

    HINT!  conversie string - lista || (string.split("delimiter"))
    """

    ################### TO DO #########################
    
    nume_formatat = ()
    
    nume_familie = list()
    prenume1 = list()
    prenume2 = list()
    
    # Iterating through every name on the list
    # print(nume_complete[:5])
            
    for nume in nume_complete:
        familie = nume.split(" ") 
        prenume = familie[1].split("-")
        
        nume_familie.append(familie[0])
        prenume1.append(prenume[0])
        prenume2.append(prenume[1])
        
        nume_formatat = (nume_familie, prenume1, prenume2)    

    ###################################################

    return nume_formatat