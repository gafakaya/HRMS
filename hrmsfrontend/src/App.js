import "./App.css";
import Header from "./layouts/Header";
import Sidebar from "./layouts/Sidebar";

function App() {
  return (
    <div className="app">
      {/* Sidebar */}
      <Sidebar />

      <div className="app__body">
        {/* Header */}
        <Header />
        {/* Feed */}

        {/* RightSection */}
      </div>
    </div>
  );
}

export default App;
