import 'package:bloc/bloc.dart';
import 'package:injectable/injectable.dart';

import "../../../../core/network/base_handling.dart";
import '../../../../error/failure.dart';
import "../../../shared/entity/base_entity.dart";
import '../../../sample/domain/use_cases/get_{{name.snakeCase()}}.dart';
import '../../domain/entities/{{name.snakeCase()}}_entity.dart';
import '../../../../features/{{name.snakeCase()}}/domain/use_cases/get_{{name.snakeCase()}}.dart';
import '../../../../features/{{name.snakeCase()}}/domain/entities/{{name.snakeCase()}}_entity.dart';
import '../../data/models/request/{{name.snakeCase()}}_request_model.dart';

part '{{name.snakeCase()}}_state.dart';





@injectable
class {{name.pascalCase()}}Cubit extends Cubit<{{name.pascalCase()}}State> {
  final Get{{name.pascalCase()}}UseCase get{{name.pascalCase()}}UseCase;
  {{name.pascalCase()}}Cubit({required this.get{{name.pascalCase()}}UseCase}) : super({{name.pascalCase()}}InitialState());

  Future<void> get{{name.pascalCase()}}(
      {required {{name.pascalCase()}}RequestModel {{name.camelCase()}}Model}) async {
    emit({{name.pascalCase()}}LoadingState());

    final CustomResponseType<BaseEntity<{{name.pascalCase()}}Entity>> eitherPackagesOrFailure =
        await get{{name.pascalCase()}}UseCase({{name.camelCase()}}Model);

    eitherPackagesOrFailure.fold((Failure failure) {
      final FailureToMassage massage = FailureToMassage();
      emit({{name.pascalCase()}}ErrorState(
        message: massage.mapFailureToMessage(failure),
      ));
    }, (BaseEntity<{{name.pascalCase()}}Entity> response) {
      emit({{name.pascalCase()}}ReadyState(response));
    });
  }
}

















import 'package:injectable/injectable.dart';

import '../../../../core/network/base_handling.dart';
import '../../../shared/entity/base_entity.dart';
import '../../domain/repositories/{{name.snakeCase()}}_repository.dart';
import '../data_sources/{{name.snakeCase()}}_sources.dart';
import '../models/request/{{name.snakeCase()}}_request_model.dart';
import '../models/response/{{name.snakeCase()}}_response_model.dart';

@Injectable(as: {{name.pascalCase()}}Repository)
class {{name.pascalCase()}}RepositoryImp implements {{name.pascalCase()}}Repository {
  {{name.pascalCase()}}RepositoryImp({
    required this.homeProfileRemoteDataSource,
  });

  final {{name.pascalCase()}}RemoteDataSource homeProfileRemoteDataSource;

  Future<CustomResponseType<BaseEntity<{{name.pascalCase()}}Model>>> get{{name.pascalCase()}}(
      {required {{name.pascalCase()}}RequestModel homeProfileRequestModel}) async {
    return await homeProfileRemoteDataSource.getProfile(
        homeProfileRequestModel: homeProfileRequestModel);
  }
}
