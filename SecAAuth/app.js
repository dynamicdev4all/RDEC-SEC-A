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
  .catch(() => {
    console.log("Some issue in connection");
  });

// app.use(express.static);

const path = require("path");

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
app.post("/create-new-user", (req, res) => {
  console.log(req.body);
  console.log(res.body);
  // ({ username, email, password } = req.body);
  // console.log(username);
  // console.log(email);
  // console.log(password);
});

app.listen(1234, () => {
  console.log("the server is running");
});
