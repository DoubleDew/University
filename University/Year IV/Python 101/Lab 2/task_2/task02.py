def task(*args):
    '''
    args -> elemente de tipuri diferite
    return -> lista cu elementele corespunzatoare
    '''

    result = []

    ################### TO DO #########################
    
    good_int = lambda x: type(x) == int
    good_consonant = lambda x: type(x) != "aeiou"
    
    for i in args:
        if good_int(i) == True:
            result.append(i)
        elif good_consonant(i) == True:
            result.append(i)
        else:
            result.append(None)

    ###################################################
    
    return result
