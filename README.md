# BMI_Calculator-Android-App

[![License: MIT](https://img.shields.io/badge/License-GNU-blue.svg)](LICENSE)  
[![Platform](https://img.shields.io/badge/platform-Android-brightgreen)](https://developer.android.com)  
[![Made With Flask](https://img.shields.io/badge/backend-Flask-blue)](https://flask.palletsprojects.com)  
[![OkHttp](https://img.shields.io/badge/client-OkHttp-orange)](https://square.github.io/okhttp/)  
[![API Status](https://img.shields.io/website?url=https%3A%2F%2Fbmicalculatorapi.vercel.app%2Fapi%2Fbmi%2F70%2F1.75)](https://bmicalculatorapi.vercel.app/api/bmi/70/1.75)

A simple and functional **BMI Calculator Android App** built to showcase full-stack Android development skills. This app calculates Body Mass Index (BMI) by communicating with a **Python Flask API** deployed on Vercel and handles requests using **OkHttp** on the Android side.


## 🛠 Tech Stack

- **Frontend (Android)**  
  Java, XML, OkHttp  

- **Backend (API)**  
  Python, Flask, Deployed on Vercel  


## ⚙️ Features

- Input height and weight in a clean UI  
- Uses **GET** requests to fetch BMI from the cloud  
- OkHttp-powered API calls  
- Displays BMI value and health category  
- Lightweight, responsive, and serverless  



## 🔗 API Details

**Base URL:**  
```bash
https://bmicalculatorapi.vercel.app/api/bmi/{weight}/{height}
```

**Method:** `GET`

**Example:**  
```
https://bmicalculatorapi.vercel.app/api/bmi/87.9/1.75
```

**Response:**
```json
{
  "Category": "Overweight",
  "bmi": 28.702,
  "height": 1.75,
  "weight": 87.9
}
```



## 📱 Screenshots



## 🚀 Purpose

This project was created to:

- Practice Android + Python Flask integration  
- Explore REST APIs using OkHttp  
- Deploy and test Python backend using Vercel  
- Demonstrate end-to-end mobile app development  


## 🧑‍💻 How to Run

1. Clone the repo  
2. Open the project in **Android Studio**
3. Build and run on your device/emulator  


## 🤝 Contributing

1. Fork this repository  
2. Create a new branch: `git checkout -b feature-name`  
3. Make your changes  
4. Commit: `git commit -m "Added feature"`  
5. Push: `git push origin feature-name`  
6. Create a Pull Request  

## ✍️ Author
Developed By Subham Kumar Sinha.

## 📄 License

This project is licensed under the [GNU License](LICENSE).

