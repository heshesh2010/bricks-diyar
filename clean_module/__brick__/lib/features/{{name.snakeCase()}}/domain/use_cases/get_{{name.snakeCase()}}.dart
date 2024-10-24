import "../../../../core/domain/usecase/base_usecase.dart";
import "../../data/models/request/{{name.snakeCase()}}_request_model.dart";
import "../../domain/entities/{{name.snakeCase()}}_entity.dart";
import "../../domain/repositories/{{name.snakeCase()}}_repository.dart";

import 'package:injectable/injectable.dart';
import '../../../shared/entity/base_entity.dart';
import '../../../../core/network/base_handling.dart';




@injectable
class Get{{name.pascalCase()}}UseCase implements UseCase<BaseEntity<{{name.pascalCase()}}Entity>, {{name.pascalCase()}}RequestModel> {
    Get{{name.pascalCase()}}UseCase ({required this.{{name.camelCase()}}Repository});

  final {{name.pascalCase()}}Repository {{name.camelCase()}}Repository;


  @override
  Future<CustomResponseType<BaseEntity<{{name.pascalCase()}}Entity>>> call(
    {{name.pascalCase()}}RequestModel params,
  ) {
    {{^addTemplateCode}}
    // TODO: implement call
    throw UnimplementedError();
    {{/addTemplateCode}}
    {{#addTemplateCode}}
    return {{name.camelCase()}}Repository.get{{name.pascalCase()}}({{name.camelCase()}}Params: params);
    {{/addTemplateCode}}
  }
}
