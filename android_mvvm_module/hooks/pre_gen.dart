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
  
  // Check for conflicting options
  final useFlow = context.vars['useFlow'] as bool;
  final useLiveData = context.vars['useLiveData'] as bool;
  
  if (useFlow && useLiveData) {
    logger.warn('Both Flow and LiveData are enabled. Flow will be used by default.');
    context.vars['useLiveData'] = false;
  }
  
  logger.success('Pre-generation checks passed ✓');
}
