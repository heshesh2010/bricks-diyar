import SwiftUI

struct {{name.pascalCase()}}ListView: View {
    @StateObject private var viewModel = {{name.pascalCase()}}ViewModel()
    
    var body: some View {
        VStack {
            switch viewModel.state {
            case .idle:
                Text("Press button to load items")
                    .padding()
            case .loading:
                ProgressView("Loading...")
                    .padding()
            case .success(let items):
                List(items) { item in
                    HStack {
                        Text("\(item.ip)")
                        Spacer()
                        Text(item.userAgent)
                            .foregroundColor(.gray)
                            .italic()
                    }
                }
            case .failure(let message):
                VStack {
                    Text("Error: \(message)")
                        .foregroundColor(.red)
                    Button("Retry") {
                        viewModel.fetchItems()
                    }
                }
            }
        }
        .onAppear {
            viewModel.fetchItems()
        }
        .padding()
    }
}

#Preview {
    {{name.pascalCase()}}ListView()
}
