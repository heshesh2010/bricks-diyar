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














