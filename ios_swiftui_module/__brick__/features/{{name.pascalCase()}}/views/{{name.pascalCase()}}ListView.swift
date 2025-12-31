import SwiftUI

struct {{name.pascalCase()}}ListView: View {
    @StateObject private var viewModel = {{name.pascalCase()}}ViewModel()

    var body: some View {
        NavigationView {
            List(viewModel.items) { item in
                NavigationLink(destination: {{name.pascalCase()}}DetailView(item: item)) {
                    Text(item.title)
                }
            }
            .navigationTitle("{{name.pascalCase()}} List")
            .onAppear {
                viewModel.fetchItems()
            }
        }
    }
}
