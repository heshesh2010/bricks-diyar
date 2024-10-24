part of '{{name.snakeCase()}}_cubit.dart';

class {{name.pascalCase()}}ErrorState extends {{name.pascalCase()}}State {
  final String? message;

  {{name.pascalCase()}}ErrorState({this.message});
}

final class {{name.pascalCase()}}InitialState extends {{name.pascalCase()}}State {}

final class {{name.pascalCase()}}LoadingState extends {{name.pascalCase()}}State {}

final class {{name.pascalCase()}}ReadyState extends {{name.pascalCase()}}State {
  {{name.pascalCase()}}ReadyState(this.response);
    BaseEntity<{{name.pascalCase()}}Entity> response;

}

abstract class {{name.pascalCase()}}State {}
