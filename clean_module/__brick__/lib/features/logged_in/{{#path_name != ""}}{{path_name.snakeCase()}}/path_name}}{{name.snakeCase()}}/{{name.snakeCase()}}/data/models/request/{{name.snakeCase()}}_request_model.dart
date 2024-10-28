
import 'package:json_annotation/json_annotation.dart';

part '../../../../../../{{name.snakeCase()}}/data/models/request/{{name.snakeCase()}}_request_model.g.dart';


  {{#areCommentsOn}}/*
  The params class is responsible for holding the data that will be used to make the request to the API. 
  It is also responsible for converting the data into a format that the API can use. 
  This could involve serializing objects into JSON, or mapping objects to database rows.
  */{{/areCommentsOn}}


@JsonSerializable()
class {{name.pascalCase()}}RequestModel {
  {{name.pascalCase()}}RequestModel({required this.email, required this.lang});

  factory {{name.pascalCase()}}RequestModel.fromJson(Map<String, dynamic> json) =>
      _${{name.pascalCase()}}RequestModelFromJson(json);
  final String? email;
  final String? lang;

  Map<String, dynamic> toJson() => _${{name.pascalCase()}}RequestModelToJson(this);
}

