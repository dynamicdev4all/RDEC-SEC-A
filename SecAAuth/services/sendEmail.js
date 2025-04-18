const nodemailer = require('nodemailer');
const jwt = require('jsonwebtoken');
const JWT_SECRET="this_is_top_secret"

const sendEmail = (email, userName)=>{
    const emailTrasnsport = nodemailer.createTransport({
        service:"gmail",
        auth:{
            user:"test.duck.mail@gmail.com",
            pass:"nqmzajowuqxxpvhj"
        }
    })
    const verificationCode = jwt.sign({email}, JWT_SECRET, {expiresIn:"5m"})
    // const verificationCode = "cmVnZXQzNzY0MEBjeG5sYWIuY29t"
    const verificationLink = `http://localhost:1234/verifyemail?code=${verificationCode}`
    
    const emailToSend = ({
        from:"test.duck.mail@gmail.com",
        to:email,
        subject:"Sec-A-Auth | Verification Mail",
        // text:`-Dear ${userName}, \nYour account has been created successfully. \n\nPlease click on the link below to verify your account. \nIf you did not requested this email, please ignore this message. \n\nThanks. \nTeam Sec-A`
        html:`<h3>Dear ${userName}</h3>
        <br>
        <p>Your account has been created successfully.</p>
        <br>
        <p>Please click on the link below to verify your account.</p>
        <br>
        <a href=${verificationLink}>${verificationLink}</a>
        <br>
        <p>If you did not requested this email, please ignore this message.</p>
        <br>
        <p>Thanks.</p>
        <br>
        <p>Team Sec-A</p>`
    })

    emailTrasnsport.sendMail(emailToSend,(err)=>{
        if(err){
            console.log("Email Sent Fail ", err)
        }
        else{
            console.log("Email Sent Success")
        }
    })
}


// sendEmail("pieby*two014@gmail.com", "Deepak")

module.exports = sendEmail;


// http://shaktitool.com/verifyemail/cmVnZXQzNzY0MEBjeG5sYWIuY29t
// http://localhost:1234/verifyemail/cmVnZXQzNzY0MEBjeG5sYWIuY29t