def verify_translation(word, translation):
    bird = {
        'a': 'apa',
        'e': 'epe',
        'i': 'ipi',
        'o': 'opo',
        'u': 'upu'
    }
    
    translated_word = ""
    
    for char in word:
        if char in bird:
            translated_word += bird[char]
        else:
            translated_word += char
            
    return translated_word == translation

if __name__ == "__main__":
    
    word = input()
    translation = input()
    
    print(verify_translation(word, translation))
