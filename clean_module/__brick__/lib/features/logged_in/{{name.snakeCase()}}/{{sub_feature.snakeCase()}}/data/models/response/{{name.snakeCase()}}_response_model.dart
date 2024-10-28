
import 'package:json_annotation/json_annotation.dart';
import '../../../../../../shared/entity/base_entity.dart';
import '../../../domain/entities/{{name.snakeCase()}}_entity.dart';

part '../../../../data/models/response/{{name.snakeCase()}}_response_model.g.dart';



/// Model that transforms the {{name.pascalCase()}} data from the API to the
/// application entity
  {{#areCommentsOn}}
  /*
  The model is responsible for converting the data into a format that the rest of the application can use. 
  This could involve deserializing JSON from an API into objects, or mapping database rows to objects.
  */
  {{/areCommentsOn}}


@JsonSerializable()
class {{name.pascalCase()}}Model extends {{name.pascalCase()}}Entity {
  {{name.pascalCase()}}Model(
      {
   required super.var1,
    required super.var2,});

  factory {{name.pascalCase()}}Model.fromJson(Map<String, dynamic> json) =>
      _${{name.pascalCase()}}ModelFromJson(json);

  Map<String, dynamic> toJson() => _${{name.pascalCase()}}ModelToJson(this);
}

@JsonSerializable()
class {{name.pascalCase()}}ResponseModel extends BaseEntity<{{name.pascalCase()}}Model> {
  const {{name.pascalCase()}}ResponseModel({
    super.statusCode,
    super.data,
    super.message,
    super.totalRecords,
    super.hasMorePages,
  });

  factory {{name.pascalCase()}}ResponseModel.fromJson(Map<String, dynamic> json) =>
      _${{name.pascalCase()}}ResponseModelFromJson(json);

  Map<String, dynamic> toJson() => _${{name.pascalCase()}}ResponseModelToJson(this);
}