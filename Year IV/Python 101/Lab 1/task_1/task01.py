def func(note, nume_materie):
    """
    Trebuie sa creati un tuplu cu numele "pereche",
    in care veti tine, astfel, (media notelor, numele_materiei)
    exemplu: pereche = (...)
    """

    ################### TO DO #########################
    
    media_notelor = 0
        
    for i in note:
        media_notelor += i
    
    media_notelor = media_notelor / len(note)
    
    pereche = (media_notelor, nume_materie)
    
    ###################################################

    return pereche

print(func([1,2,3,4,5,6,7,8,9,10], "SPORT"))
