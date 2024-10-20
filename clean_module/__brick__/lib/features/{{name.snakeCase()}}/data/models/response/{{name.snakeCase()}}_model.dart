import "dart:convert";

import "../../../domain/entities/{{name.snakeCase()}}_entity.dart";

import 'package:json_annotation/json_annotation.dart';

part '{{name.snakeCase()}}_model.g.dart';


/// Model that transforms the {{name.pascalCase()}} data from the API to the
/// application entity
  {{#areCommentsOn}}
  /*
  The model is responsible for converting the data into a format that the rest of the application can use. 
  This could involve deserializing JSON from an API into objects, or mapping database rows to objects.
  */
  {{/areCommentsOn}}
@JsonSerializable()
class {{name.pascalCase()}}ResponseModel extends {{name.pascalCase()}}Entity {
  {{name.pascalCase()}}ResponseModel(this.var1, this.var2) : super(var1: '', var2: '');;

  factory {{name.pascalCase()}}ResponseModel.fromJson(Map<String, dynamic> json) =>
      _${{name.pascalCase()}}ResponseModelFromJson(json);
  final String? var1;
  final String? var2;

  Map<String, dynamic> toJson() => _${{name.pascalCase()}}ResponseModelToJson(this);

   /// Converts the {{name.pascalCase()}} model instance to an entity
  {{name.pascalCase()}}Entity toEntity() =>  {{name.pascalCase()}}Entity(
    var1: var1,
    var2: var2,
  );


   /// Factory method to create a {{name.pascalCase()}} model instance from an 
  /// entity
  factory {{name.pascalCase()}}ResponseModel.fromEntity({required {{name.pascalCase()}}Entity entity}) => const {{name.pascalCase()}}ResponseModel(
      entity.var1,
        entity.var2,
  );
  
}
