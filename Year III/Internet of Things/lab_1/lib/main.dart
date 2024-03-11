import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: FirstPage(),
  ));
}

class FirstPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Lab1'),
        ),
        body: Center(
            child: Column(
          children: <Widget>[
            Text('Albums'),
            Expanded(
              child: GridView.extent(
                primary: false,
                padding: const EdgeInsets.all(16),
                crossAxisSpacing: 20,
                mainAxisSpacing: 20,
                maxCrossAxisExtent: 400.0,
                children: <Widget>[
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Beerbongs and Bentleys',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.brown,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Stoney',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: const Color.fromARGB(255, 117, 65, 46),
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Hollywood is Bleeding',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.deepPurple,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Twelve Carat Toothache',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.grey,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Austin',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.red,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Plus',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.yellow,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'X',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.grey,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Divide',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.orange,
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Equal',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: const Color.fromARGB(255, 239, 119, 110),
                  ),
                  Container(
                    padding: const EdgeInsets.all(8),
                    child: const Text(
                      'Minus',
                      style: TextStyle(fontSize: 20),
                    ),
                    color: Colors.green,
                  ),
                ],
              ),
            ),
            ElevatedButton(
              child: Text('More Info'),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.amber,
              ),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SecondPage()),
                );
              },
            )
          ],
        )));
  }
}

class SecondPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Albums page 2'),
        ),
        body: Center(
          child: Column(
            children: <Widget>[
              Padding(
                  padding: EdgeInsets.all(35),
                  child: TextField(
                    decoration: InputDecoration(
                        border: OutlineInputBorder(), labelText: ""),
                  )),
              Image.network(
                'https://hips.hearstapps.com/del.h-cdn.co/assets/cm/15/11/3200x3272/54f65d39ab05d_-_183341797.jpg?resize=640:*',
                height: 225,
                width: 225,
              ),
              Stack(
                fit: StackFit.passthrough,
                children: <Widget>[
                  Container(
                    height: 300,
                    width: 600,
                    color: Colors.green,
                    child: const Align(
                        alignment: Alignment(0.2, 0.6),
                        child: Text(
                          'text1',
                          style: TextStyle(color: Colors.white, fontSize: 25),
                        )),
                  ),
                  Positioned(
                    top: 20,
                    right: 30,
                    child: Container(
                      height: 100,
                      width: 150,
                      color: Colors.blue,
                      child: Center(
                        child: Text(
                          'text2',
                          style: TextStyle(color: Colors.white, fontSize: 20),
                        ),
                      ),
                    ),
                  ),
                  Positioned(
                    top: 150,
                    left: 150,
                    child: Container(
                      height: 50,
                      width: 350,
                      color: Colors.pink,
                      child: Center(
                        child: Text(
                          'text3?',
                          style: TextStyle(color: Colors.white, fontSize: 20),
                        ),
                      ),
                    ),
                  ),
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  Container(
                    margin: EdgeInsets.all(10),
                    padding: EdgeInsets.all(10),
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.red,
                    ),
                    child: Text(
                      'Spider-Man',
                      style: TextStyle(color: Colors.blueAccent, fontSize: 20),
                    ),
                  ),
                  Container(
                    margin: EdgeInsets.all(10),
                    padding: EdgeInsets.all(10),
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.blue,
                    ),
                    child: Text(
                      'GOAT',
                      style: TextStyle(color: Colors.redAccent, fontSize: 20),
                    ),
                  ),
                  Container(
                    margin: EdgeInsets.all(10),
                    padding: EdgeInsets.all(10),
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green,
                    ),
                    child: Text(
                      'Forever',
                      style: TextStyle(color: Colors.white, fontSize: 20),
                    ),
                  ),
                ],
              ),
              ElevatedButton(
                child: Text('Less Info'),
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.amber,
                ),
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => FirstPage()),
                  );
                },
              )
            ],
          ),
        ));
  }
}
