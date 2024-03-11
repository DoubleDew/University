import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'products.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  Firebase.initializeApp();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Homework 2',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home:
          Product(),
    );
  }
}