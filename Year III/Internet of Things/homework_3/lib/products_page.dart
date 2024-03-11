import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';

class ProductPage extends StatefulWidget {
  @override
  _ProductPageState createState() => _ProductPageState();
}

class _ProductPageState extends State<ProductPage> {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _colorController = TextEditingController();
  bool _inStock = true;

  void _addProduct() async {
    String name = _nameController.text;
    String color = _colorController.text;
    if (name.isNotEmpty && color.isNotEmpty) {
      await _firestore.collection('products').add({
        'name': name,
        'color': color,
        'inStock': _inStock,
      });
      // Clear the text fields after successful addition
      _nameController.clear();
      _colorController.clear();
      // Optionally reset the inStock switch
      setState(() {
        _inStock = true;
      });
      // Show a success message or handle the new product UI
    } else {
      // Handle the error, show an alert or a Snackbar
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Add New Product')),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _nameController,
              decoration: InputDecoration(labelText: 'Product Name'),
            ),
            TextField(
              controller: _colorController,
              decoration: InputDecoration(labelText: 'Color'),
            ),
            SwitchListTile(
              title: Text('In Stock'),
              value: _inStock,
              onChanged: (bool value) {
                setState(() {
                  _inStock = value;
                });
              },
            ),
            ElevatedButton(
              onPressed: _addProduct,
              child: Text('Add Product'),
            ),
            // Add a widget to display list of products here if necessary
          ],
        ),
      ),
    );
  }
}
