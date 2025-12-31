import SwiftUI

struct {{name.pascalCase()}}DetailView: View {
    let item: {{name.pascalCase()}}

    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            Text(item.title)
                .font(.largeTitle)
            Text(item.description)
                .font(.body)
            Spacer()
        }
        .padding()
        .navigationTitle("Detail")
    }
}
