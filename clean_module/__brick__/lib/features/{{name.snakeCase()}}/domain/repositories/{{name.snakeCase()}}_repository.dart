{{#addTemplateCode}}import "package:dartz/dartz.dart";

import "../../../../core/errors/failure.dart";
import '../features/shared/entity/base_entity.dart';
import '../../core/network/base_handling.dart';

import "../../data/models/request/{{name.snakeCase()}}_params.dart";
import "../entities/{{name.snakeCase()}}_entity.dart";{{/addTemplateCode}}

/// Data operations for the {{name.pascalCase()}} collection
abstract class {{name.pascalCase()}}Repository {

  {{#areCommentsOn}}/*
  A repository is a collection of data operations. It is responsible for 
  abstracting the data layer from the business logic layer. 
  */{{/areCommentsOn}}

  {{#addTemplateCode}}Future<CustomResponseType<BaseEntity< {{name.pascalCase()}}Entity>>>> get{{name.pascalCase()}}({
    required {{name.pascalCase()}}Params {{name.camelCase()}}Params,
  });{{/addTemplateCode}}
}
