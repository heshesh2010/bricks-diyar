import Foundation
import Combine

class {{name.pascalCase()}}ViewModel: ObservableObject {
    @Published var items: [{{name.pascalCase()}}] = []
    private let service = {{name.pascalCase()}}Service()
    private var cancellables = Set<AnyCancellable>()

    func fetchItems() {
        service.fetchItems()
            .sink(receiveCompletion: { _ in }, receiveValue: { [weak self] items in
                self?.items = items
            })
            .store(in: &cancellables)
    }
}
