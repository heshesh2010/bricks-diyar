
import 'package:json_annotation/json_annotation.dart';

part '{{name.snakeCase()}}_request_model.g.dart';


@JsonSerializable()
class {{name.pascalCase()}}RequestModel {

    /// Parameters used to make the {{name.pascalCase()}} request.
  {{name.pascalCase()}}Params();
  
  {{#areCommentsOn}}/*
  The params class is responsible for holding the data that will be used to make the request to the API. 
  It is also responsible for converting the data into a format that the API can use. 
  This could involve serializing objects into JSON, or mapping objects to database rows.
  */{{/areCommentsOn}}


  HomeProfileRequestModel({required this.email, required this.lang});

  factory HomeProfileRequestModel.fromJson(Map<String, dynamic> json) =>
      _$HomeProfileRequestModelFromJson(json);
  final String? email;
  final String? lang;

  Map<String, dynamic> toJson() => _$HomeProfileRequestModelToJson(this);
}
