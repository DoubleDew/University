def task(register):
    '''
    register -> dictionar
    return -> lista doar cu numele studentilor
    '''
    names = []

    ################### TO DO #########################
    
    good_grade = lambda x: 1 if sum(x) / len(x) >= 8.50 else 0
    
    for key, value in register.items():
        if good_grade(value):
            names.append(key)
        

    ###################################################
    
    return names
