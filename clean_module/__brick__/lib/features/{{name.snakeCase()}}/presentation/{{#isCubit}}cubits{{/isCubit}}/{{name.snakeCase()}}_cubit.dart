import 'package:bloc/bloc.dart';
import 'package:injectable/injectable.dart';

import '../../../../core/network/base_handling.dart';
import '../../../../error/failure.dart';
import '../../../../features/shared/entity/base_entity.dart';

part '{{name.snakeCase()}}_state.dart';

@injectable
class {{name.pascalCase()}}Cubit extends Cubit<{{name.pascalCase()}}State> {
  final Get{{name.pascalCase()}}UseCase get{{name.pascalCase()}}UseCase;
  {{name.pascalCase()}}Cubit({required this.get{{name.pascalCase()}}UseCase}) : super({{name.pascalCase()}}InitialState());

  Future<void> get{{name.pascalCase()}}(
      {required {{name.pascalCase()}}RequestModel {{name.camelCase()}}Model}) async {
    emit({{name.pascalCase()}}LoadingState());

    final CustomResponseType<BaseEntity<{{name.pascalCase()}}Entity>> eitherPackagesOrFailure =
        await Get{{name.pascalCase()}}UseCase();

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





















class {{name.pascalCase()}}Cubit extends Cubit<StateMixin<{{name.pascalCase()}}Entity>> {
  
  {{name.pascalCase()}}Cubit() : super(StateMixin<{{name.pascalCase()}}Entity>.loading());

  {{#addTemplateCode}}void eitherFailureOr{{name.pascalCase()}}() async {
    {{name.pascalCase()}}RepositoryImpl repository = {{name.pascalCase()}}RepositoryImpl(
      {{#hasRemoteData}}remoteDataSource: {{name.pascalCase()}}RemoteDataSourceImpl(
        dio: DioAdapter(
          internetInfo: NetworkInfoImpl(
            InternetConnection(),
          ),
        ),
      ),{{/hasRemoteData}}
      {{#hasLocalData}}localDataSource: {{name.pascalCase()}}LocalDataSourceImpl(
        localSource: await SharedPreferences.getInstance(),
      ),{{/hasLocalData}}
      {{#hasRemoteData}}networkInfo: NetworkInfoImpl(
        InternetConnection(),
      ),{{/hasRemoteData}}
    );

     final Either<Failure, {{name.pascalCase()}}Entity> failureOr{{name.pascalCase()}} =
        await Get{{name.pascalCase()}}UseCase   ({{name.camelCase()}}Repository: repository).call(
      {{name.pascalCase()}}Params(),
    );

    failureOr{{name.pascalCase()}}.fold(
      (Failure newFailure) {
        emit(StateMixin.failure(newFailure));
      },
      ({{name.pascalCase()}}Entity? new{{name.pascalCase()}}) {
        emit(StateMixin.success(new{{name.pascalCase()}}!));
      },
    );
  }{{/addTemplateCode}}
}
