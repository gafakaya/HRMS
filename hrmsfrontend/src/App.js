import "./App.css";
import Header from "./layouts/Header";
import Sidebar from "./layouts/Sidebar";
import Feed from "./layouts/Feed";
import RightSection from "./layouts/RightSection";

function App() {
  return (
    // {/* login ? */}
    // {/* login ! */}
    <div className="app">
      <Sidebar />

      <div className="app__body">
        <Header />
        <div className="app__body__content">
          <Feed />
          <RightSection />
        </div>
      </div>
    </div>
  );
}

export default App;
