function checkIfGood(){
    const fullname = document.getElementById('fullname').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const repeatpass = document.getElementById('repeatpass').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    //const emailRegex =  /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    const phoneRegex = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;

    if(fullname === ""){
        alert("Name musn't be empty!");
        return false;
    }else if(username === ""){
        alert("Username musn't be empty!");
        return false;
    }else if(password === ""){
        alert("Password musn't be empty!");
        return false;
    }else if(repeatpass === ""){
        alert("Confirm password musn't be empty!");
        return false;
    }else if(password !== confirm){
        alert("Passwords MUST match.");
        return false;
    }else if(email === ""){
        alert("Email musn't be empty!");
        return false;
    }else if(phone === ""){
        alert("Phone number musn't be empty!");
        return false;
    }else if(phoneRegex.test(phone.value)){
        alert("Phone number does not seem to be in a phone number shape.");
        return false;
    }

    return true;
}