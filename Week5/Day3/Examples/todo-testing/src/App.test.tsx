import React from 'react';
import { fireEvent, render, screen, waitFor } from '@testing-library/react';
import App from './App';

describe("App component test suite", () => {
  it("should start with no todos", () => {
    render(<App />)

    waitFor(() => {
      expect(screen.getByText("Todo List")).toBeInTheDocument();
      expect(screen.findByText("Test Title")).not.toBeInTheDocument();
      expect(screen.findByText("Test Description")).not.toBeInTheDocument();
    });
  });

  it("should append a new todo when the submit button of the form is pressed", () => {
    render(<App />);

    fireEvent.change(screen.getByPlaceholderText("Todo Title"), {target: {value: "Test Title"}});
    fireEvent.change(screen.getByPlaceholderText("Todo Description"), {target: {value: "Test Description"}});
    fireEvent.click(screen.getByText("Create Todo"));

    waitFor(() => {
      expect(screen.getByText("Test Title")).toBeInTheDocument();
      expect(screen.getByText("Test Description")).toBeInTheDocument();
  });
  })

});
