class {{name.pascalCase()}}Service {
    private let network: NetworkHandler

    init(network: NetworkHandler = .shared) {
        self.network = network
    }

    func fetchItems(completion: @escaping (Result<[{{name.pascalCase()}}], NetworkErrorHandler>) -> Void) {
        network.get({{name.pascalCase()}}.self, path: APIConstants.ipEndpoint) { result in
            switch result {
                case .success(let item): completion(.success([item]))
                case .failure(let err): completion(.failure(err))
            }
        }
    }
}
