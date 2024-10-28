


import 'package:injectable/injectable.dart';

import '../../../../../../../core/network/base_handling.dart';
import '../../../../../../shared/entity/base_entity.dart';
import '../../domain/repositories/{{name.snakeCase()}}_repository.dart';
import '../models/request/{{name.snakeCase()}}_request_model.dart';
import '../models/response/{{name.snakeCase()}}_response_model.dart';
import '../../../../../{{name.snakeCase()}}/data/data_sources/remote/{{name.snakeCase()}}_remote_data_source.dart';

@Injectable(as: {{name.pascalCase()}}Repository)
class {{name.pascalCase()}}RepositoryImp implements {{name.pascalCase()}}Repository {
  {{name.pascalCase()}}RepositoryImp({
    required this.{{name.camelCase()}}RemoteDataSource,
  });

  final {{name.pascalCase()}}RemoteDataSource {{name.camelCase()}}RemoteDataSource;

  Future<CustomResponseType<BaseEntity<{{name.pascalCase()}}Model>>> get{{name.pascalCase()}}(
      {required {{name.pascalCase()}}RequestModel {{name.camelCase()}}Params}) async {
    return await {{name.camelCase()}}RemoteDataSource.get{{name.pascalCase()}}(
        {{name.camelCase()}}RequestModel: {{name.camelCase()}}Params);
  }
}


