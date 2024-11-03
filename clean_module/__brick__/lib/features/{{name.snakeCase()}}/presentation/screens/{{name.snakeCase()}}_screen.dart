
import 'dart:async';

import 'package:auto_route/auto_route.dart';
import 'package:flutter/material.dart';
import '../../../di/dependency_init.dart';
import '../../../routes/route_sevices.dart';
import '../../../routes/routes.gr.dart';
import '../cubits/{{name.snakeCase()}}_cubit.dart';
import 'package:easy_localization/easy_localization.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import '../../../common/extensions/size_extensions.dart';
import '../../../shared/widgets/app_text.dart';
import '../../../shared/widgets/master_widget.dart';
import 'package:get_it/get_it.dart';


@RoutePage()
class {{name.pascalCase()}}Screen extends StatefulWidget {
  const {{name.pascalCase()}}Screen({super.key});

  @override
  State<{{name.pascalCase()}}Screen> createState() => _{{name.pascalCase()}}ScreenState();
}

class _{{name.pascalCase()}}ScreenState extends State<{{name.pascalCase()}}Screen> {
  @override
  void initState() {
    super.initState();
   
  }

  @override
  Widget build(BuildContext context) {
    return  MasterWidget(
       screenTitle: context.tr("applicationSettings"),
      widget: Center(
        child: Text('Splash Screen'),
      ),
    );
  }
}