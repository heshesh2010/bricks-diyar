 import "package:equatable/equatable.dart";





/// Entity that contains the data of the {{name.pascalCase()}}.
class {{name.pascalCase()}}Entity extends Equatable{

 final String? var1;

 final  String? var2;
  /// Entity that contains the data of the {{name.pascalCase()}}.
   {{name.pascalCase()}}Entity(
    {required this.var1, required this.var2}
   );

  {{#areCommentsOn}}/*
  An entity represents a real-world object with a distinct identity. 
  */{{/areCommentsOn}}

  @override
  List<Object?> get props => [
  {{#areCommentsOn}}/*
  List your entity attributes here 
  */{{/areCommentsOn}}
  ];


}