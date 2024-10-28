import 'package:dartz/dartz.dart';
import 'package:injectable/injectable.dart';

import '../../../../../../../../core/network/api/network_apis_constants.dart';
import '../../../../../../../../core/network/base_handling.dart';
import '../../../../../../../../core/network/network_helper.dart';
import '../../../../../../../../error/failure.dart';
import '../../../../../../../{{name.snakeCase()}}/data/data_sources/models/request/{{name.snakeCase()}}_request_model.dart';
import '../../../../../../../{{name.snakeCase()}}/data/data_sources/models/response/{{name.snakeCase()}}_response_model.dart';

abstract class {{name.pascalCase()}}RemoteDataSource {
  Future<CustomResponseType<{{name.pascalCase()}}ResponseModel>> get{{name.pascalCase()}}(
      {required {{name.pascalCase()}}RequestModel {{name.camelCase()}}RequestModel});
}

@Injectable(as: {{name.pascalCase()}}RemoteDataSource)
class {{name.pascalCase()}}DataSourceImpl implements {{name.pascalCase()}}RemoteDataSource {
  {{name.pascalCase()}}DataSourceImpl(this.networkHelper);
  final NetworkHelper networkHelper;

  @override
  Future<CustomResponseType<{{name.pascalCase()}}ResponseModel>> get{{name.pascalCase()}}(
      {required {{name.pascalCase()}}RequestModel {{name.camelCase()}}RequestModel}) async {
    ({dynamic response, bool success}) result = await networkHelper
        .post(path: ApiConstants.profile, data: <String, String>{
      "email": {{name.camelCase()}}RequestModel.email ?? "",
      "lang": {{name.camelCase()}}RequestModel.lang ?? "a"
    });

    if (result.success) {
   
      return right({{name.pascalCase()}}ResponseModel.fromJson(result.response));
    } else {
      return left(ServerFailure(message: result.response as String));
    }
  }
}
