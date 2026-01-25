import 'package:mason/mason.dart';

void run(HookContext context) {
  final logger = context.logger;
  final name = context.vars['name'];
  
  logger.info('Generating Android MVVM module: $name');
  
  // Validate that name is not empty
  if (name == null || name.toString().isEmpty) {
    logger.err('Feature name cannot be empty');
    throw Exception('Feature name is required');
  }
  
  logger.success('Pre-generation checks passed ✓');
}
