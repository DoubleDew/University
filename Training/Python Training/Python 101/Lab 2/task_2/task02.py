def task(*args):
    '''
    args -> elemente de tipuri diferite
    return -> lista cu elementele corespunzatoare
    '''

    result = []

    ################### TO DO #########################
    
    lower = lambda x: 1 if x.islower() else 0
    good_consonant = lambda x: 0 if x in 'aeiou' else 1
    not_word = lambda x: 1 if len(x) == 1 else 0
    not_symbol = lambda x: 1 if x.isalpha() else 0  
    
    for i in args:
        if(type(i) == int or type(i) == str and lower(i) and good_consonant(i) and not_word(i) and not_symbol(i)):
            result.append(i)
        
    ###################################################
    
    return result