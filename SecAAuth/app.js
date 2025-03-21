const express = require("express");

const mongoose = require("mongoose");

const app = express();

mongoose
  .connect(
    "mongodb+srv://piebytwo014:piebytwo014@cluster0.n8om1.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  )
  .then(() => {
    console.log("Database connection Success");
  })
  .catch((err) => {
    console.log("Some issue in connection ", err);
  });

// app.use(express.static);

const path = require("path");
const { emit } = require("process");

app.use(express.urlencoded({ extended: true }));

const userSchema = new mongoose.Schema({
  userName: String,
  email: String,
  passsword: String,
  isActive: Boolean,
});

const userModel = mongoose.model("User", userSchema);

//this is the root route or home route
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});
app.get("/register", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "register.html"));
});
app.get("/login", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "login.html"));
});
app.get("/dashboard", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "dashboard.html"));
});
app.post("/create-new-user", async (req, res) => {
  const { username, email, password } = req.body;
  try {
    const user = await userModel.findOne({ email: email });
    if (user) {
      console.log("This Email is already in use");
    } else {
      const newUser = new userModel({
        userName: username,
        email: email,
        passsword: password,
        isActive: false,
      });
      await newUser.save();
      console.log("register success");
    }
  } catch (error) {
    console.log(error);
  }
});
app.post("/login-user", async (req, res) => {
  const { email, password } = req.body;
  console.log(req.body);
  try {
    const user = await userModel.findOne({ email: email });
    if (user) {
      if (user.passsword == password && user.isActive) {
        res.redirect("/dashboard");
      } else if (user.passsword == password && !user.isActive) {
        console.log("Please verify your email");
      } else if (user.passsword != password) {
        console.log("Password is invalid ");
      }
    } else {
      console.log("The user does not exist");
    }
  } catch (error) {
    console.log(error);
  }
});

app.listen(1234, () => {
  console.log("the server is running");
});
